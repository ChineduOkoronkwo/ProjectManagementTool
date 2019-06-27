import React, {Component} from "react";

class CreateProjectButton extends Component {
    render() {
        return (
            <a href="/addProject" className="btn btn-lg btn-info">
                Create a Project
            </a>        
        );        
    }
}

export default CreateProjectButton;