package com.miniapp.countryside.exception;

public enum ExceptionType {
    INNER_ERROR(500, "系统内部错误"),
    UNAUTHORIZED(401, "未登录"),
    BAD_REQUEST(400, "请求错误"),
    FORBIDDEN(403, "无权操作"),
    NOT_FOUND(404, "未找到"),
    // 01为模块，001第一个错误
    USER_NAME_DUPLICATE(40001001, "用户名重复"),
    USER_NOT_FOUND(40401002, "用户不存在"),
    USER_PASSWORD_NOT_MATCH(40001003, "用户名或密码错误"),
    SONG_DUPLICATE(40002001,"该歌曲已存在"),
    LESSON_DUPLICATE(40005001,"您已上传过该名字的课程"),
    USER_NOT_ENABLED(50001001, "用户未启用"),
    USER_LOCKED(50001002, "用户被锁定"),
    USER_OPEN_ID_NOT_FOUND(40401003, "未找到openId绑定用户"),
    SONG_NOT_FOUND(40402001, "该歌曲已不存在"),
    NEWS_NOT_FOUND(40403001, "该资讯已不存在"),
    VIDEO_NOT_FOUND(40404001,"该视频已不存在"),
    LESSON_NOT_FOUND(40405001,"该课程已不存在"),
    SURROUNDING_NOT_FOUND(40406001,"该周围已不存在"),
    FILE_NOT_PERMISSION(40303002, "当前用户无权限修改文件"),
    SEARCH_SONG_NOT_FOUND(40402002, "搜索的歌手或歌曲不存在"),
    SEARCH_NEWS_NOT_FOUND(40403002,"搜索的资讯不存在"),
    SEARCH_LESSON_NOT_FOUND(40405002,"搜索的课程不存在"),
    NO_MINE_SURROUNDING(40406003,"还没有已上传的周围哦~"),
    NO_MINE_VIDEO(40404003,"还没有已上传的小视频哦~");
//    ARTIST_NOT_FOUND(40405001, "歌手不存在"),
//    ALBUM_NOT_FOUND(40406001, "专辑不存在");


    private final Integer code;

    private final String message;


    ExceptionType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
