<template>
    <div class="login-container">
        <el-card class="box-card">
            <div class="login-body">
                <div class="login-title" @click="toIndex">
                    <img src="@/assets/03.png" style="
                                width: 40px;
                                height: 40px;
                                margin: 5px 5px -5px 0;
                                -webkit-user-drag: none;
                                -khtml-user-drag: none;
                                -moz-user-drag: none;
                                user-drag: none;
                            " />
                    <b style="color: black;display: inline-block; margin-bottom: 20px;font-size: 28px;">
                        二手交易平台
                    </b>
                </div>
                <el-form ref="form" :model="userForm">
                    <el-input placeholder="请输入手机号码..." v-model="userForm.accountNumber" class="login-input">
                        <template slot="prepend">
                            <div class="iconfont icon-r-user2" style="font-size: 24px;"></div>
                        </template>
                    </el-input>
                    <el-input placeholder="请输入密码..." v-model="userForm.userPassword" class="login-input"
                        @keyup.enter.native="login" show-password>
                        <template slot="prepend">
                            <div class="iconfont icon-r-lock" style="font-size: 24px;"></div>
                        </template>
                    </el-input>

                  <el-form-item  prop="code"  style="width: 350px" >
                    <el-input v-model="userForm.code" style="width: 197px;float: left">
                      <template slot="prepend">
                        <div class="iconfont icon-r-user2" style="font-size: 24px;"></div>
                      </template>
                    </el-input>
                    <el-image :src="captchaImg" class="captchaImg" @click.native="getCaptcha"></el-image>
                  </el-form-item>
                    <div class="login-submit">
                        <el-button type="primary" @click="login"> 登录</el-button>
                        <el-button type="warning" autocomplete="off" @click="$router.push('/sign-in')"
                            style="margin-left: 20px"> 注册</el-button>
                    </div>
                    <div class="other-submit">
                        <router-link to="/login-admin" class="sign-in-text"> 管理员登录</router-link>
                    </div>
                </el-form>
            </div>
        </el-card>
    </div>
</template>

<script>
export default {
    name: "login",
    data() {
        return {
            userForm: {
                accountNumber: '',
                userPassword: '',
                code:''
            },
          token:null,
          captchaImg:null
        };
    },

    methods: {
        login() {
            this.$api.userLogin({
                accountNumber: this.userForm.accountNumber,
                userPassword: this.userForm.userPassword,
                code:this.userForm.code,
                token:this.token
            }).then(res => {
                console.log(res);
                if (res.status_code === 1) {
                    res.data.signInTime = res.data.signInTime.substring(0, 10);
                    this.$globalData.userInfo = res.data;
                    this.$router.replace({ path: '/index' });
                } else {
                    this.$message.error(res.msg);
                }
            }).catch((e) => {
                console.log(e)
                if (
                    e.response == undefined ||
                    e.response.data == undefined
                ) {
                    this.$message({
                        showClose: true,
                        message: e,
                        type: "error",
                        duration: 20000,
                    });
                } else {
                    this.$message({
                        showClose: true,
                        message: e.response.data,
                        type: "error",
                        duration: 20000,
                    });
                }
            });
        },
      getCaptcha(){
        this.$api.getCaptcha().then(
            res=>{
              console.log(res)
              this.captchaImg=res.captcha
              this.token=res.token
              this.userForm.code=''

            }
        )
      },
        toIndex() {
            this.$router.replace({ path: '/index' });
        }
    }
}
</script>

<style scoped>
.captchaImg{
  float: left;
  margin-left: 8px;
  border-radius: 2px;
}
.login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    width: 100%;
    
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    overflow-y: auto;
    height: 100%;
    background: url("../../assets/background.jpg") center top / cover no-repeat;

}

.login-body {
    padding: 30px;
    width: 300px;
    height: 100%;
}

.login-title {
    padding-bottom: 30px;
    text-align: center;
    font-weight: 600;
    font-size: 20px;
    color: #409EFF;
    cursor: pointer;
}

.login-input {
    margin-bottom: 20px;
}

.login-submit {
    margin-top: 20px;
    display: flex;
    justify-content: center;
}

.sign-in-container {
    padding: 0 10px;
}

.sign-in-text {
    color: #409EFF;
    font-size: 16px;
    text-decoration: none;
    line-height: 28px;
}

.other-submit {
    display: flex;
    justify-content: space-between;
    margin-top: 30px;
    margin-left: 200px;
}
</style>