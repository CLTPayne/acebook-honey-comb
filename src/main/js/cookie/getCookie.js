import history from '../history'
import { Redirect } from 'react-router'


function getCookie(cookieName){
    var decodedcookie = decodeURIComponent(document.cookie);
    var tokenindex = decodedcookie.indexOf(cookieName+"=");
    var aftertokenindex = decodedcookie.slice(tokenindex);
    var array = aftertokenindex.split("=");
    return array[1]
    }

export { getCookie }

