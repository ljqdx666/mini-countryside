DROP TABLE IF EXISTS `song`;
CREATE TABLE `song`  (
                         `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '音乐id',
                         `song_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '歌曲名称',
                         `singer_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '歌手姓名',
                         `song_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '歌曲文件链接',
                         `song_pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '歌曲图片链接',
                         `created_time` datetime(6) NOT NULL ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '创建时间',
                         `updated_time` datetime(6) NOT NULL ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;
