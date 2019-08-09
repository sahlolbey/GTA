import React from "react";
import ReactDOM from "react-dom";
import Signup from "./signup";
import Result from "./result";
import {BrowserRouter as Router, Route} from "react-router-dom";


// tag::vars[]
/*
const React = require('react');
const ReactDOM = require('react-dom');
*/


class App extends React.Component {

  constructor(props) {
    super(props);

  }

  componentDidMount() {

  }

  render() {
    return (
        <div>
          <Router>
            <Route path="/" exact={true} component={Signup}/>
            <Route path="/result" component={Result}/>
          </Router>

        </div>
    )
  }
}

ReactDOM.render(
    <App/>,
    document.getElementById('react')
)

