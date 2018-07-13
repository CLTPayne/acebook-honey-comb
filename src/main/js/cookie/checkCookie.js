import history from '../history';
import { Redirect } from 'react-router';
import { getCookie } from './getCookie';

(function checkCookie() {
    var cookie = getCookie("ACKL_token");
    if (cookie != "") {
        history.push('/')
    } else {
         history.push('/signin')


    }
})();