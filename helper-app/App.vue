<script>
	export default {
		//全局变量
		globalData: {
			token:''
		},
		onLaunch: function() {

			plus.push.addEventListener(
				'click',
				function(msg) {
					uni.navigateTo({
						url: 'pages/new_order/new_order'
					});
				},
				false
			);
			plus.push.addEventListener(
				'receive',
				function(msg) {
					uni.navigateTo({
						url: 'pages/new_order/new_order'
					});
				},
				false
			);
			console.log('App Launch')
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		}
	}
</script>

<style>
	/*每个页面公共css */
</style>
