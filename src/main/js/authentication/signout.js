import React from "react";
const client = require('../client');
import SignUp from './signup'
import history from '../history'



class SignOut extends React.Component {
      signOut(){
        document.cookie = "ACKL_token=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
        history.push('/')
      }


      render() {
        return (
        <button onClick={this.signOut} > SignOut </button>
       );
    }
}

export default SignOut;