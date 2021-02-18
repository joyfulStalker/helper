<template>
	<view class="center">
		<view class="logo" @click="goLogin" :hover-class="!login ? 'logo-hover' : ''">
			<image class="logo-img" :src="login ? uerInfo.avatarUrl :avatarUrl"></image>
			<view class="logo-title">
				<text class="uer-name">Hi，{{login ? uerInfo.name : '您未登录'}}</text>
				<text class="go-login navigat-arrow" v-if="!login">&#xe65e;</text>
			</view>
		</view>
		<view class="center-list">
			<view class="center-list-item border-bottom">
				<text class="list-icon">&#xe60f;</text>
				<text class="list-text">帐号管理</text>
				<text class="navigat-arrow">&#xe65e;</text>
			</view>
			<view class="center-list-item">
				<text class="list-icon">&#xe639;</text>
				<text class="list-text">新消息通知</text>
				<text class="navigat-arrow">&#xe65e;</text>
			</view>
		</view>
		<view class="center-list">
			<view class="center-list-item border-bottom">
				<text class="list-icon">&#xe60b;</text>
				<text class="list-text">帮助与反馈</text>
				<text class="navigat-arrow">&#xe65e;</text>
			</view>
			<view class="center-list-item">
				<text class="list-icon">&#xe65f;</text>
				<text class="list-text">服务条款及隐私</text>
				<text class="navigat-arrow">&#xe65e;</text>
			</view>
		</view>
		<view class="center-list">
			<view class="center-list-item">
				<text class="list-icon">&#xe614;</text>
				<text class="list-text">关于应用</text>
				<text class="navigat-arrow">&#xe65e;</text>
			</view>
		</view>
		<view class="center-list">
			<view class="center-list-item">
				<text class="list-text" style="text-align: center;" @click="logout()">退出当前账号</text>
			</view>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				login: false,
				avatarUrl: "../../static/logo.png",
				uerInfo: {}
			}
		},
		methods: {

			isLogin() {
				// 判断缓存中是否登录过，直接登录
				try {
					let token = uni.getStorageSync('token');
					let isVisitor = getApp().globalData.isVisitor;
					console.log(token, isVisitor)

					if (isVisitor == false && !token) {
						//有登录信息
						console.log("用户未登录或token过期");
						uni.redirectTo({
							url: '../login/login',
						});
					}
				} catch (e) {

					// error
				}
			},
			logout() {
				console.log("tuichu")
				getApp().globalData.isVisitor = true;
				uni.removeStorageSync("token");
				uni.reLaunch({
					url: '../login/login',
				});
			}
		}
	}
</script>

<style>
	@import url("./css/main.css");
</style>
