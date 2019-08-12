import React from "react";
import "../resources/static/css/main.css";

class Result extends React.Component {

  render() {

    return (
        <div>
            <div style={{height: '50px'}}>&nbsp;</div>
            <div className="center result" style={{width: '50%', height: '300px'}}>
                <div className="form-group center" style={{width: 'max-content'}}>
                    <span className="center" style={{marginTop: 20}}>Subscriber added successfully</span>
                </div>
                <div className="form-group center" style={{width: 'max-content'}}>
                    <a onClick={() => this.handleClick()} className="btn btn-success center"
                       style={{marginTop: 20}}>Add another </a>
                </div>
            </div>
        </div>
    )
  }
    
    handleClick() {
        this.props.history.push("/");
    }

}


export default Result;



