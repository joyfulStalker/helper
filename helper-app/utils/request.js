module.exports = (params) => {
	let url = 'http://192.168.1.5:9000' + params.url;
	let method = params.method;
	let header = params.header || {};
	let data = params.data || {};
	if (method) {
		method = method.toLocaleUpperCase();
		if (method == "POST") {
			header = {
				"content-type": "application/json",
				"token": getApp().globalData.token
			}
		} else {
			header = {
				"token": getApp().globalData.token
			}
		}
	}
	console.log("======>" + header.token)
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
