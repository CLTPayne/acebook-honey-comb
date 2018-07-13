import React from "react";
import client from "../client";
import { getCookie } from "../cookie/getCookie";

class AddPost extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            content: "",
            token: getCookie("ACKL_token")
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
                  token : this.state.token
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
            <div className="textarea">
                <form id="post" className="post" onSubmit={this.handleSubmit}>
                    <label>
                        Content
                        <br/>
                        <
                            textarea
                            rows="10"
                            cols="50"
                            placeholder="Type your post here..."
                            type="text" name="content"
                            value={this.state.content}
                            onChange={this.handleChange}
                        />
                    </label>
                    <br/>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
        )
    }
}

export default AddPost;