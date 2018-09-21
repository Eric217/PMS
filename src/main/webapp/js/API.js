
var BASE_URL = "http://localhost:8080";

var API = {

    // common user:
    login:          BASE_URL + "/user/login",
    image_code:     BASE_URL + "/user/login/code",
    login_type:     BASE_URL + "/user/type",
    register:       BASE_URL + "/user/register/code",
    register_code:  BASE_URL + "/user/register/mail",
    resetPass_code: BASE_URL + "/user/resetPassword/mail",
    resetPassword:  BASE_URL + "/user/resetPassword/code",
    logout:         BASE_URL + "/user/logout",

    // student
    get_project:    BASE_URL + "/student/project/all",
    create_proj:    BASE_URL + "/student/project/create",
    get_my_managed: BASE_URL + "/student/project/managed",
    get_noti:       BASE_URL + "/noti/get",
    get_bull:       BASE_URL + "/bull/get",


    // admin
    get_pro_admin:  BASE_URL + "/admin/project/all"




};

var ROLE = {
    no_user:    0,
    normal:     1,
    lab:        2,
    admin:      3
}

var ProjectStatus = {
    checking: "审核中",
    rejected: "已拒绝",
    canceled: "已取消",
    processing: "进行中",
    finished: "已完成",
    overtime: "已超时",

    request_modi: "请求修改中",
    request_chck: "请求检查中"
}


/** 简单的 param， k = p，否则  */
// var parseParam = function(param) {
//     var params = [];
//     $.each(param, function(i) {
//         var value = param[i];
//         if (typeof value === 'undefined')
//             value = '';
//         params.push([i, encodeURIComponent(value)].join('='));
//     });
//     return params.join('&');
// };
//
// var getURL = function (param) {
//     return BASE_URL + '?' + parseParam(param);
// }