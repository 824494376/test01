package com.pinzhi.action.energyEffAssess;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.pinzhi.business.model.energyEffAssessObject.EfProduceNode;
import com.pinzhi.business.service.energyEffAssessObject.EfProduceNodeService;
import com.pinzhi.business.service.energyEffAssessObject.EfShiftProduceRecService;
import com.pinzhi.business.service.energyEffAssessObject.EfShiftService;
import com.pinzhi.frame.base.Struts2Utils;
import com.pinzhi.utils.ExcelTools;
import com.pinzhi.utils.NumberUtils;

/**
 * 考核报表
 * 
 * @author renruicong
 * 
 */
@SuppressWarnings("deprecation")
public class AssessReportAction {

	@Autowired
	private EfShiftService shiftService;
	@Autowired
	private EfProduceNodeService produceNodeService;
	@Autowired
	private EfShiftProduceRecService shiftProduceRecService;

	private String startDate;
	private String endDate;
	private Long produceNo;
	private int energyTypeNo;

	private String arrayData;// 报表数据

	/**
	 * 异步获取考核数据
	 */
	public void getAssessReportData() {
		// 查询参数设置
		Map<String, Object> criteria = new HashMap<String, Object>();
		criteria.put("produceNo", produceNo);
		criteria.put("energyNo", energyTypeNo);
		criteria.put("startDate", startDate);
		criteria.put("endDate", endDate);

		// 考核报表数据
		List<Map<String, Object>> assessReportByTeams = shiftProduceRecService.getGroupCostPerUnit(criteria);

		DecimalFormat df = new DecimalFormat("#0.000");// 格式化数据

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		if (null != assessReportByTeams && assessReportByTeams.size() > 0) {
			EfProduceNode produceNode = produceNodeService.getById(produceNo);// 产量节点

			for (int i = 0; i < assessReportByTeams.size(); i++) {
				Map<String, Object> assessReportByTeam = assessReportByTeams.get(i);

				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("teamname", produceNode.getNodename() + " 【" + assessReportByTeam.get("GROUPNO") + "】组");
				Double data = assessReportByTeam.get("TOTALDATA") == null ? null : NumberUtils.toDouble(assessReportByTeam.get("TOTALDATA"));
				resultMap.put("cost", df.format(data));
				data = assessReportByTeam.get("AMOUNT") == null ? null : NumberUtils.toDouble(assessReportByTeam.get("AMOUNT"));
				resultMap.put("output", df.format(data));
				data = assessReportByTeam.get("COSTPERUNIT") == null ? null : NumberUtils.toDouble(assessReportByTeam.get("COSTPERUNIT"));
				resultMap.put("costPerUnit", df.format(data));
				resultMap.put("produceName", produceNode.getProductname());
				resultMap.put("ProductUnit", produceNode.getProductunit());

				result.add(resultMap);
			}
		}

		Struts2Utils.renderJson(result);
	}

	/**
	 * 导出考核报表
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public void exportExcel() throws IOException, JSONException {
		Struts2Utils.getRequest().setCharacterEncoding("UTF-8");
		String fileName = Struts2Utils.getRequest().getParameter("filename");
		JSONArray excelArray = null;
		if (null != arrayData && !arrayData.equals("")) {
			excelArray = new JSONArray(arrayData);// 将字符串转换为JSONArray数组
		}

		String energyUnit = Struts2Utils.getRequest().getParameter("energyUnit") == null ? "KWh" : Struts2Utils.getRequest().getParameter("energyUnit");
		energyUnit = energyUnit.replace("<sup>3</sup>", "³");// 输出立方米
		String produceUnit = Struts2Utils.getRequest().getParameter("produceUnit") == null ? "t" : Struts2Utils.getRequest().getParameter("produceUnit");

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("能效EXCEL报表");// 创建一个数据工作区
		HSSFCellStyle style = ExcelTools.getStyle(wb);// 单元格的样式

		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 6));
		HSSFRow titleRow = sheet.createRow(0);
		ExcelTools.createTitle(wb, titleRow, 0, fileName);

		HSSFRow headRow = sheet.createRow(2);
		sheet.setDefaultColumnWidth(20); // 设置默认的列宽
		// 创建标题列
		HSSFCellStyle headerStyle = ExcelTools.getStyleHeader(wb);// 表头单元格的样式
		ExcelTools.createHeader(wb, headerStyle, headRow, 0, "班组");
		ExcelTools.createHeader(wb, headerStyle, headRow, 1, "用量(" + energyUnit + ")");
		ExcelTools.createHeader(wb, headerStyle, headRow, 2, "产量(" + produceUnit + ")");
		ExcelTools.createHeader(wb, headerStyle, headRow, 3, "单产能耗(" + energyUnit + "/" + produceUnit + ")");
		ExcelTools.createHeader(wb, headerStyle, headRow, 4, "产品名称");
		ExcelTools.createHeader(wb, headerStyle, headRow, 5, "产品单位");
		ExcelTools.createHeader(wb, headerStyle, headRow, 6, "单位");

		if (null != excelArray) {
			for (int i = 0; i < excelArray.length(); i++) {
				JSONObject obj = excelArray.getJSONObject(i);
				HSSFRow row = sheet.createRow(3 + i);
				ExcelTools.createCell(wb, style, row, 0, obj.getString("teamname"));
				ExcelTools.createCell(wb, style, row, 1, obj.get("cost").equals("") ? "" : String.format("%.3f", obj.getDouble("cost")));
				ExcelTools.createCell(wb, style, row, 2, obj.get("output").equals("") ? "" : String.format("%.3f", obj.getDouble("output")));
				ExcelTools.createCell(wb, style, row, 3, obj.get("costPerUnit").equals("") ? "" : String.format("%.3f", obj.getDouble("costPerUnit")));
				ExcelTools.createCell(wb, style, row, 4, obj.getString("produceName"));
				ExcelTools.createCell(wb, style, row, 5, obj.getString("ProductUnit"));
				ExcelTools.createCell(wb, style, row, 6, obj.getString("unit"));
			}
		} else {
			sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 6));
			HSSFRow row = sheet.createRow(3);
			ExcelTools.createCell(wb, style, row, 0, "无数据");
		}

		if (Struts2Utils.getRequest().getHeader("user-agent").indexOf("MSIE") != -1) {
			fileName = java.net.URLEncoder.encode(fileName, "utf-8") + ".xls";
		} else {
			fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1") + ".xls";
		}
		Struts2Utils.getResponse().setHeader("Content-disposition", "attachment;filename=" + fileName.replace(" ", ""));

		OutputStream out = Struts2Utils.getResponse().getOutputStream();
		// 输出文件
		wb.write(out);
		out.flush();
		out.close();
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Long getProduceNo() {
		return produceNo;
	}

	public void setProduceNo(Long produceNo) {
		this.produceNo = produceNo;
	}

	public int getEnergyTypeNo() {
		return energyTypeNo;
	}

	public void setEnergyTypeNo(int energyTypeNo) {
		this.energyTypeNo = energyTypeNo;
	}

	public String getArrayData() {
		return arrayData;
	}

	public void setArrayData(String arrayData) {
		this.arrayData = arrayData;
	}

}
