import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import * as validator from "validator";
import axios from "axios";


class Signup extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      fields: {name: '', email: ''},
      errors: {}
    }
  }

  render() {
    const {name, email} = this.state.fields;
    const {errors} = this.state;
    return (
        <div>
          <h2>Signup Form</h2>
          <form onSubmit={(event) => this.handleSubmit(event)}
                className="col-lg-5" style={{marginTop: 20}}>
            <div className="form-group">
              <label>Full Name:</label>
              <input name="name"
                     value={name}
                     className={["form-control", errors["name"] ? 'is-invalid' : ''].join(' ')}
                     onChange={(event) => this.handleChange(event)}
                     placeholder="Please Enter Your Full Name"/>
              <span className="invalid-feedback"
                    style={{display: errors["name"] ? 'block' : 'none'}}>{errors["name"]}</span>
            </div>
            <div className="form-group">
              <label>Email:</label>
              <input name="email"
                     value={email}
                     className={["form-control", errors["email"] ? 'is-invalid' : ''].join(' ')}
                     onChange={(event) => this.handleChange(event)}
                     placeholder="Please Enter your email"/>
              <span className="invalid-feedback"
                    style={{display: errors["email"] ? 'block' : 'none'}}>{errors["email"]}</span>
            </div>
            <div className="form-group">
              <button type="submit" className="btn btn-danger">Signup</button>
            </div>
          </form>
        </div>
    )
  }

  handleSubmit(event) {
    event.preventDefault();
    this.handleValidation((valid) => {
      if (valid) {
        this.handleRequest();
      } else {
        console.log(this.state.errors);
      }
    })

  }

  handleChange(event) {
    let fields = this.state.fields;
    let target = event.target;
    fields[target.name] = target.value;
    this.setState({fields});
  }

  handleValidation(callback) {
    let {fields} = this.state;
    let errors = {};
    let formIsValid = true;

    if (validator.isEmpty(fields.email)) {
      formIsValid = false;
      errors["email"] = "Email can not be empty";
    } else if (!validator.isEmail(fields.email)) {
      formIsValid = false;
      errors["email"] = "Wrong email address";
    }

    if (validator.isEmpty(fields.name)) {
      formIsValid = false;
      errors["name"] = "Full Name can not be empty";
    }

    this.setState({errors}, () => {
      callback(formIsValid);
    });
    return formIsValid;

  }

  handleRequest() {
    const {name, email} = this.state.fields;
    let formData = new FormData();
    formData.append('email', email);
    formData.append('name', name);

    axios.post("api/addSubscriber", formData)
        .then(response => {
              console.log(response);
              this.props.history.push("/result");

            }
        ).catch(error => {
          console.log(error);
        }
    )

    ;
  }
}

export default Signup;