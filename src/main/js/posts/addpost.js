import React from "react";
import client from "../client";

class AddPost extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            content: "",
            token: ""
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        let data = {
                  content : this.state.content,
                  token : "$2a$10$GBSG3lRRYRpfFWz4FP8SgOcVLdcU2h85rVSBIBEmsL19CVOa/dlLi"
                  }

        $.ajax({
                  url: "http://localhost:8080/posts",
                  type: "POST",
                  data: JSON.stringify(data),
                  contentType:"application/json"
                 });
    }

    render() {
        return(
            <form id="post" onSubmit={this.handleSubmit}>
                <label>
                    Content
                    <textarea placeholder="Type your post here..." type="text" name="content" value={this.state.content} onChange={this.handleChange}/>
                </label>
                <input type="submit" value="Submit"/>
            </form>
        )
    }
}

export default AddPost;