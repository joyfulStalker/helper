module.exports = (params) => {
	let url = 'http://perfect.imdo.co:27867/helper' + params.url;
	// let url = 'http://192.168.1.5:9000' + params.url;
	let method = params.method;
	let header = params.header || {};
	let data = params.data || {};
	let token = uni.getStorageSync('token') || '';
	if (method) {
		method = method.toLocaleUpperCase();
		if (method == "POST") {
			header = {
				"content-type": "application/json",
				"token": token
			}
		} else {
			header = {
				"token": token
			}
		}
	}
	console.log("======>" + header.token)
	// console.log(url)
	uni.request({
		url: url,
		method: method,
		header: header,
		data: data,
		dataType: "json",
		sslVerify: false,
		success: res => {

			if (res.code && res.code != 200) {
				uni.showModal({
					content: res.msg
				})
				return;
			}
			typeof params.success == "function" && params.success(res.data)
		}

	})

}
