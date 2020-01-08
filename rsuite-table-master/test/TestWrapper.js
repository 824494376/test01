/**
 * https://stackoverflow.com/questions/36682241/testing-functional-components-with-renderintodocument
 */
import React from 'react';
import { findDOMNode } from 'react-dom';
import ReactTestUtils from 'react-dom/test-utils';

class Wrapper extends React.Component {
  render() {
    return this.props.children;
  }
}

export function getInstance(children) {
  return ReactTestUtils.renderIntoDocument(children);
}

export function getDOMNode(children) {
  return findDOMNode(getInstance(children));
}

export const findDOM = findDOMNode;

export default Wrapper;
