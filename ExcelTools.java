package com.pinzhi.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExcelTools {
	
	public static HSSFCellStyle getStyleHeader(HSSFWorkbook wb){//表头单元格样式
	  HSSFCellStyle style = wb.createCellStyle();
	  style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
//	  style.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
      style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
      style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
      style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
      style.setBorderRight(HSSFCellStyle.BORDER_THIN);
      style.setBorderTop(HSSFCellStyle.BORDER_THIN);
      style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
      // 生成一个字体
      HSSFFont font = wb.createFont();
      font.setColor(HSSFColor.WHITE.index);
      font.setFontHeightInPoints((short) 9);
      font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
      // 把字体应用到当前的样式
      style.setFont(font);
      return style;
	}
	public static HSSFCellStyle getStyle(HSSFWorkbook wb){//数字与字符单元格样式
	    HSSFCellStyle style = wb.createCellStyle();
//        style.setFillForegroundColor(HSSFColor.WHITE.index);
//        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	public static HSSFCellStyle getStyleGrey(HSSFWorkbook wb){//灰色单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	public static HSSFCellStyle getStyleRed(HSSFWorkbook wb){//红色单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.RED.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	public static HSSFCellStyle getStyleYellow(HSSFWorkbook wb){//黄色单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.YELLOW.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	public static HSSFCellStyle getStyleOrange(HSSFWorkbook wb){//橙色单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		HSSFPalette customPalette = wb.getCustomPalette();  
		customPalette.setColorAtIndex(HSSFColor.ORANGE.index, (byte) 255, (byte) 153, (byte) 0); 
		style.setFillForegroundColor(HSSFColor.ORANGE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	public static HSSFCellStyle getStylePink(HSSFWorkbook wb){//粉色单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		HSSFPalette customPalette = wb.getCustomPalette();  
		customPalette.setColorAtIndex(HSSFColor.PINK.index, (byte) 214, (byte) 205, (byte) 213); 
		style.setFillForegroundColor(HSSFColor.PINK.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	public static HSSFCellStyle getStyleGreyWhite(HSSFWorkbook wb){//白色单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		HSSFPalette customPalette = wb.getCustomPalette();  
		customPalette.setColorAtIndex(HSSFColor.WHITE.index, (byte) 215, (byte) 214, (byte) 208); 
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	public static HSSFCellStyle getStyleWhite(HSSFWorkbook wb){//白色单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.WHITE.index);
//		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	public static HSSFCellStyle getStyleBlue(HSSFWorkbook wb){//蓝色单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	public static HSSFCellStyle getStyleGreen(HSSFWorkbook wb){//绿色单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREEN.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	
	public static HSSFCellStyle getStyleRedRGB(HSSFWorkbook wb){//RGB红色单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		HSSFPalette customPalette = wb.getCustomPalette();  
		customPalette.setColorAtIndex(HSSFColor.RED.index, (byte) 255, (byte) 200, (byte) 200); 
		style.setFillForegroundColor(HSSFColor.RED.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	public static HSSFCellStyle getStyleGreenRGB(HSSFWorkbook wb){//RGB绿色单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		HSSFPalette customPalette = wb.getCustomPalette();  
		customPalette.setColorAtIndex(HSSFColor.GREEN.index, (byte) 220, (byte) 255, (byte) 240);
		style.setFillForegroundColor(HSSFColor.GREEN.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	public static HSSFCellStyle getStyleBlueRGB(HSSFWorkbook wb){//RGB蓝色单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		HSSFPalette customPalette = wb.getCustomPalette();  
		customPalette.setColorAtIndex(HSSFColor.BLUE.index, (byte) 150, (byte) 240, (byte) 255);
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	public static HSSFCellStyle getStyleTitle(HSSFWorkbook wb){
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.WHITE.index);
//		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成一个字体
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 15);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	    // 把字体应用到当前的样式
	    style.setFont(font);
		return style;
	}
	//创建表头行单元格
	public static void createHeader(HSSFWorkbook wb,HSSFCellStyle style,HSSFRow titleRow,int column,String title){
		titleRow.setHeight((short) 500);
		HSSFCell titleCell = titleRow.createCell(column);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		titleCell.setCellStyle(style); //关联样式
		if(null != title)
			titleCell.setCellValue(title.replace("<sup>3</sup>", "³").replace("m<sup>2</sup>", "㎡").replace("M<sup>2</sup>", "㎡")); //列内容
		else
			titleCell.setCellValue(title); //列内容
	}
	//创建表头行单元格,合并单元格，设置边框
	public static void createHeader_(HSSFWorkbook wb,HSSFCellStyle style,HSSFRow titleRow,int column,int endColumn,String title){
		for(int i = column; i<=endColumn; i++){
			HSSFCell titleCell = titleRow.createCell(i);
			titleCell.setCellStyle(style); // 关联样式
			titleCell.setCellValue(title); // 列内容
		}
	}
	//创建标题行单元格
	public static void createTitle(HSSFWorkbook wb,HSSFRow titleRow,int column,String title){
		HSSFCell titleCell = titleRow.createCell(column);
		titleCell.setCellStyle(getStyleTitle(wb)); //关联样式
		titleCell.setCellValue(title); //列内容
	}
	//创建字符串单元格
	public static void createCell(HSSFWorkbook wb,HSSFCellStyle style,HSSFRow row,int column,String cellValue){
	  row.setHeight((short) 500);	
	  HSSFCell cell = row.createCell(column);
	  cell.setCellStyle(style);
	  cell.setCellValue(cellValue);
	}
	//创建字符串单元格
	public static void createCell(HSSFWorkbook wb,HSSFCellStyle style,HSSFRow row,int column,String cellValue,String formula){
	  row.setHeight((short) 500);	
	  HSSFCell cell = row.createCell(column);
	  if(null!=formula&&!"".equals(formula)) cell.setCellFormula(formula);
	  cell.setCellStyle(style);
	  cell.setCellValue(cellValue);
	}

	//创建数字单元格
	public static void createNumberCell(HSSFWorkbook wb,HSSFCellStyle style,HSSFRow row,int column,String cellValue){
	  row.setHeight((short) 500);
	  HSSFCell cell = row.createCell(column);
	  style.setDataFormat((short) cell.CELL_TYPE_NUMERIC);
	  cell.setCellStyle(style);
	  if(cellValue.equals("/"))
		  cell.setCellValue(cellValue);
	  else if(cellValue.equals("null"))
		  cell.setCellValue("/");
	  else if(cellValue.equals("empty"))
		  cell.setCellValue("");
	  else
		  cell.setCellValue(cellValue);
//		  cell.setCellValue(Double.parseDouble(String.valueOf(cellValue))) ;
//	  	  cell.setCellValue(Double.valueOf(cellValue));
	}
	//创建灰色单元格
	public static void createGreyCell(HSSFWorkbook wb,HSSFCellStyle greyStyle,HSSFRow row,int column,String cellValue){
		HSSFCell cell = row.createCell(column);
		cell.setCellStyle(greyStyle);
		cell.setCellValue(cellValue);
	}
	 /**
	  * 判断从Excel文件中解析出来数据的格式
	  * @param cell
	  * @return
	  */
    public static String getCellValue(HSSFCell cell) {
        String value = null;
        // 简单的查检列类型
        switch (cell.getCellType()) {
        case HSSFCell.CELL_TYPE_STRING:// 字符串
            value = cell.getRichStringCellValue().getString();
            break;
        case HSSFCell.CELL_TYPE_NUMERIC:// 数字
            long dd = (long) cell.getNumericCellValue();
            value = dd + "";
            break;
        case HSSFCell.CELL_TYPE_BLANK:
            value = "";
            break;
        case HSSFCell.CELL_TYPE_FORMULA:
            value = String.valueOf(cell.getCellFormula());
            break;
        case HSSFCell.CELL_TYPE_BOOLEAN:// boolean型值
            value = String.valueOf(cell.getBooleanCellValue());
            break;
        case HSSFCell.CELL_TYPE_ERROR:
            value = String.valueOf(cell.getErrorCellValue());
            break;
        default:
            break;
        }
        return value;
    }
	
    /**
     * 一般表格导出
     * @param excelDataArr
     * @param columnArr
     * @param headerStr
     * @param wb
     * @param sheet
     * @param ss
     * @throws JSONException
     */
    public static void excelFillData(JSONArray excelDataArr, JSONArray columnArr,String headerStr,HSSFWorkbook wb, HSSFSheet sheet,String...str)  {
    	
    	HSSFHeader header = sheet.getHeader();
    	header.setCenter(headerStr);
    	HSSFRow headRow = sheet.createRow(3);
    	sheet.setDefaultColumnWidth(15); // 设置默认的列宽
    	// 创建标题列
    	HSSFCellStyle headerStyle = ExcelTools.getStyleHeader(wb);// 表头单元格的样式
    	
    	try {
    		for (int i = 0; i < columnArr.length(); i++) {
    			JSONObject json = columnArr.getJSONObject(i);
    			int colNo = json.getInt("colNo");
    			String colName = json.get("colName").toString();
    			ExcelTools.createHeader(wb, headerStyle, headRow, colNo, colName);
    		}
    		
    		HSSFCellStyle style = ExcelTools.getStyle(wb);// 单元格的样式
    		
    		// 创建内容列
    		for (int i = 0,length= excelDataArr.length(); i < length; i++) {
    			JSONObject json = excelDataArr.getJSONObject(i);
    			HSSFRow row = sheet.createRow(i + 4);
    			
    			for (int j = 0; j < columnArr.length(); j++) {
    				JSONObject json_ = columnArr.getJSONObject(j);
    				int colNo = json_.getInt("colNo");
    				String colKey = json_.getString("colKey");
    				String dataType = "string";
    				String cellDataType = "";
    				if(json.has("dataType_"+colKey)){//数据类型精确到单元格配置
    					cellDataType = json.getString("dataType_"+colKey);//单元格数据类型，如果单元格定义了数据类型，则单元格数据类型优先
    				}
    				
    				if("".equals(cellDataType)&&json_.has("dataType")){
    					dataType = json_.getString("dataType");//列数据类型
    				}else
    					dataType = cellDataType;
    				
    				if(json.has(colKey)&&null!=json.get(colKey)){
    					String data = json.get(colKey).toString();
    					if(!"".equals(data)&& !"null".equals(data) ){
    						if("datetime".equalsIgnoreCase(dataType)){//日期类型
    							ExcelTools.createCell(wb, style, row, colNo, data);
    						}else if("number".equalsIgnoreCase(dataType)){//数字类型
    							if(json_.has("precision")&&null!=json_.get("precision")){
    								int precision = json_.getInt("precision");
    								ExcelTools.createNumberCell(wb, style, row, colNo, String.format("%."+precision+"f", Float.parseFloat(data)));
    							}else
    								ExcelTools.createNumberCell(wb, style, row, colNo, data);
    						}else if("formula".equalsIgnoreCase(dataType)){//公式类型
    							ExcelTools.createCell(wb, style, row, colNo, "",data);
    						}else{//字符串类型
    							ExcelTools.createCell(wb, style, row, colNo, data);
    						}
    					} else{
    						ExcelTools.createCell(wb, style, row, colNo, "");
    					} 
    				}else{
    					ExcelTools.createCell(wb, style, row, colNo, "");
    				}
    				
    			}
    			
    			
    		}
    	} catch (NumberFormatException e) {
    		e.printStackTrace();
    	} catch (JSONException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    /**
     * 复杂列头表格导出
     * @param excelDataArr
     * @param columnArr
     * @param headerStr
     * @param wb
     * @param sheet
     * @param ss
     * @throws JSONException
     */
    public static void excelFillDataWithMergedColumn(JSONArray excelDataArr, JSONArray columnArr,String headerStr,HSSFWorkbook wb, HSSFSheet sheet,String...ss) throws JSONException {
        HSSFHeader header = sheet.getHeader();
        header.setCenter(headerStr);
        sheet.setDefaultColumnWidth(15); // 设置默认的列宽
        // 创建标题列
        HSSFCellStyle headerStyle = ExcelTools.getStyleHeader(wb);// 表头单元格的样式
        JSONArray columnRealDataArr = null;
        int dataRowFrom = 3;
        for (int i = 0; i < columnArr.length(); i++) {
        	  JSONObject jsonData = columnArr.getJSONObject(i);
        	  JSONArray columnDataArr = jsonData.getJSONArray("data");
        	  int rowFromHead = jsonData.getInt("rowFrom");
        	  HSSFRow headRow = sheet.createRow(rowFromHead);
        	  
        	  if(jsonData.has("isDataCol")&&jsonData.getInt("isDataCol")==1){//isDataCol = 1 标识为此行是实际的数据列头        
        		  columnRealDataArr = columnDataArr;
        		  dataRowFrom = rowFromHead +1;
        	  }
        	  for (int j = 0; j < columnDataArr.length(); j++) {
        		  JSONObject json = columnDataArr.getJSONObject(j);
	        	  int colNo = json.getInt("colNo");
	        	  String colName = json.getString("colName");
	        	  
	        	  int isMerge=0,rowFrom = 3,colFrom = 0,rowTo = 0,colTo = 0;
	        	  if(json.has("isMerge")){
	        		  isMerge = json.getInt("isMerge");
	        	  }
	        	  if(json.has("rowFrom")){
	        		  rowFrom = json.getInt("rowFrom");
	        	  }
	        	  if(json.has("colFrom")){
	        		  colFrom = json.getInt("colFrom");
	        	  }
	        	  if(json.has("rowTo")){
	        		  rowTo = json.getInt("rowTo");
	        	  }
	        	  if(json.has("colTo")){
	        		  colTo = json.getInt("colTo");
	        	  }
	        	  
	        	  if(isMerge == 1){
	        		  ExcelTools.createHeader(wb, headerStyle, headRow, colFrom, colName);
	        		  									 //起始行号，终止行号， 起始列号，终止列号
	        		  sheet.addMergedRegion(new CellRangeAddress(rowFrom, rowTo , colFrom, colTo));
	        	  }else{
	        		  ExcelTools.createHeader(wb, headerStyle, headRow, colNo, colName);
	        	  }
        	  }
        }
        
        HSSFCellStyle style = ExcelTools.getStyle(wb);// 单元格的样式
        // 创建内容列
        
        for (int i = 0; i < excelDataArr.length(); i++) {
            JSONObject json = excelDataArr.getJSONObject(i);
            HSSFRow row = sheet.createRow(i + dataRowFrom);
            
            for (int j = 0; j < columnRealDataArr.length(); j++) {
	          	  JSONObject json_ = columnRealDataArr.getJSONObject(j);
	          	  int colNo = json_.getInt("colNo");
	          	  String colKey = json_.getString("colKey");
	          	  String dataType = "string";
	          	if(json_.has("dataType")){
	          		dataType = json_.getString("dataType");//单元格数据类型
	          	}
	          	
	          	if(json.has(colKey)&&null!=json.get(colKey)){
	          		  String data = json.get(colKey).toString();
	          		  if(!"".equals(data)&& !"null".equals(data) ){
		          		  if("datetime".equalsIgnoreCase(dataType)){//日期类型
		              		  ExcelTools.createCell(wb, style, row, colNo, data);
		            	  }else if("number".equalsIgnoreCase(dataType)){//数字类型
		            		  if(json_.has("precision")&&null!=json_.get("precision")){
		            			  int precision = json_.getInt("precision");
		            			  ExcelTools.createNumberCell(wb, style, row, colNo,  String.format("%."+precision+"f", Float.parseFloat(data)));
		            		  }else
		            			  ExcelTools.createNumberCell(wb, style, row, colNo, data);
		            	  }else{//字符串类型
		            		  ExcelTools.createCell(wb, style, row, colNo, data);
		            	  }
	          		} else{
	 	          		 ExcelTools.createCell(wb, style, row, colNo, "");
		          	  } 
	          	  }else{
	          		 ExcelTools.createCell(wb, style, row, colNo, "");
	          	  }
	          	  
           }
            

        }
       
    }
    
    /**
     * 一般表格导出
     * @param excelDataArr
     * @param columnArr
     * @param headerStr
     * @param wb
     * @param sheet
     * @param ss
     * @throws JSONException
     */
    public static void excelFillDatass(JSONArray excelDataArr, JSONArray columnArr,String headerStr,HSSFWorkbook wb, HSSFSheet sheet,String...str)  {
    	
    	HSSFHeader header = sheet.getHeader();
    	header.setCenter(headerStr);
    	HSSFRow headRow = sheet.createRow(3);
    	sheet.setDefaultColumnWidth(15); // 设置默认的列宽
    	// 创建标题列
    	HSSFCellStyle headerStyle = ExcelTools.getStyleHeader(wb);// 表头单元格的样式
    	
    	try {
    		for (int i = 0; i < columnArr.length(); i++) {
    			JSONObject json = columnArr.getJSONObject(i);
    			int colNo = json.getInt("colNo");
    			String colName = json.get("colName").toString();
    			ExcelTools.createHeader(wb, headerStyle, headRow, colNo, colName);
    		}
    		
    		HSSFCellStyle style = ExcelTools.getStyle(wb);// 单元格的样式
    		
    		// 创建内容列
    		int count = 4;
    		for (int i = 0,length= excelDataArr.length(); i < length; i++) {
    			JSONObject json = excelDataArr.getJSONObject(i);
    			HSSFRow row = sheet.createRow(i + count);
    			
    			for (int j = 0; j < columnArr.length(); j++) {
    				JSONObject json_ = columnArr.getJSONObject(j);
    				int colNo = json_.getInt("colNo");
    				String colKey = json_.getString("colKey");
    				String dataType = "string";
    				String cellDataType = "";
    				if(json.has("dataType_"+colKey)){//数据类型精确到单元格配置
    					cellDataType = json.getString("dataType_"+colKey);//单元格数据类型，如果单元格定义了数据类型，则单元格数据类型优先
    				}
    				
    				if("".equals(cellDataType)&&json_.has("dataType")){
    					dataType = json_.getString("dataType");//列数据类型
    				}else
    					dataType = cellDataType;
    				
    				if(json.has(colKey)&&null!=json.get(colKey)){
    					String data = json.get(colKey).toString();
    					if(!"".equals(data)&& !"null".equals(data) ){
    						if("datetime".equalsIgnoreCase(dataType)){//日期类型
    							ExcelTools.createCell(wb, style, row, colNo, data);
    						}else if("number".equalsIgnoreCase(dataType)){//数字类型
    							if(json_.has("precision")&&null!=json_.get("precision")){
    								int precision = json_.getInt("precision");
    								ExcelTools.createNumberCell(wb, style, row, colNo, String.format("%."+precision+"f", Float.parseFloat(data)));
    							}else
    								ExcelTools.createNumberCell(wb, style, row, colNo, data);
    						}else if("formula".equalsIgnoreCase(dataType)){//公式类型
    							ExcelTools.createCell(wb, style, row, colNo, "",data);
    						}else{//字符串类型
    							ExcelTools.createCell(wb, style, row, colNo, data);
    						}
    					} else{
    						ExcelTools.createCell(wb, style, row, colNo, "");
    					} 
    				}else{
    					ExcelTools.createCell(wb, style, row, colNo, "");
    				}
    				
    			}
    			
    			
    		}
    	} catch (NumberFormatException e) {
    		e.printStackTrace();
    	} catch (JSONException e) {
    		e.printStackTrace();
    	}
    	
    }   
}
