import React from 'react';
import Posts from './posts'
import AddPost from "./addpost"
import SignOut from "../authentication/signout"
const client = require('../client');


class PostsBuilder extends React.Component {
  constructor(props) {
    super(props)
    this.state = {posts: []};
  }

  componentDidMount() {
    client({method: 'GET', path: '/api/posts'}).then(response => {
      this.setState({posts: response.entity._embedded.posts});
    });
  }

	render() {
		return (
		<div>
		    <AddPost />
		    <SignOut />
            <Posts posts={this.state.posts}/>
        </div>
		)
	}
}

export default PostsBuilder;
