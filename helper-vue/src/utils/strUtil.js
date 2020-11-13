var StrLenUtil = (str, len) => {

    let length = 0;
    for (var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) > 255) {
            length = length + 2;
        }
        else {
            length = length + 1;
        }
    }
    if (length >= len * 2) {

        return str.slice(0, (len * 2)) + '···';
    }
    return str;
}

export default {
    StrLenUtil
}
