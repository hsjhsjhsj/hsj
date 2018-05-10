将项目上传至GitHub:
git init
git add .
git commit -m "注释语句"
git config --global user.email "hushunjian950420@163.com"
git config --global user.name "hushunjian"
git remote add origin https://github.com/hushunjian/hushunjian
git pull origin master
git push -u origin master

        

Linux环境下安装jdk:
yum install java-1.8.0-openjdk* -y 


Linux环境下安装Git:
yum install -y git


Linux环境下安装SVN
https://blog.csdn.net/weixin_37998647/article/details/78686246


Linux环境下安装rz:
yum provides */rz
yum install -y lrzsz


Linux环境下安装mysql:
yum install mysql
yum install mysql-server
yum install mysql-devel


设置密码
set password for 'root'@'localhost' =password('password');	

设置所有ip都可以访问数据库
grant all privileges on *.* to root@'%'identified by 'mysql'
参考网址:http://www.cnblogs.com/starof/p/4680083.html
解决错误问题:https://blog.csdn.net/tys1986blueboy/article/details/7056835/
卸载mysql:http://www.jb51.net/article/97516.htm
http://blog.sina.com.cn/s/blog_4f925fc30102wi6b.html


Linux环境下查看网络端口信息:
netstat -ntpl


查看防火墙状态:
iptables -vnL

关闭防火墙指令:https://blog.csdn.net/irhythm/article/details/51242388


清除防火墙中链的规则
iptables -F


使用navicat连接远程linux的mysql中文显示乱码的问题:
右键->连接属性->高级->去掉使用mysql字符集，编码选择(65001)utf-8


GitHub删除target文件夹:
git pull origin master 
dir
git rm -r --cached target
git commit -m '删除target文件夹'
git push -u origin master



启动，停止mysql服务
service mysqld start
service mysqld stop
service mysqld restart


linux命令行登录mysql
mysql --user=root -p


mysql常用命令
show databases
use mysql
show tables
create database apps
drop database apps
show variables like '%character%'



Linux查看系统语言
echo $LANG


查看安装的语言包
locale

安装中文语言包
yum groupinstall chinese-support


修改mysql字符编码
[client]
default-character-set=utf8
[mysql]
default-character-set=utf8
[mysqld]
default-character-set=utf8
参考网址：http://blog.csdn.net/xlgen157387/article/details/52781632



重启虚拟机
reboot


安装中文输入法
yum install "@Chinese Support"



打包，解压缩命令
unzip 压缩包 解压含有多个压缩文件



Linux下安装Nginx
检查常用必备支持库  rpm -qa | grep gcc
安装g++,gcc  yum install gcc-c++
参考网址:https://www.linuxidc.com/Linux/2016-08/134110.htm


Linux下安装redis
$ wget http://download.redis.io/releases/redis-4.0.8.tar.gz
$ tar xzf redis-4.0.8.tar.gz
$ cd redis-4.0.8
$ make
切换到src目录下使用make install
启动redis服务
redis-server /usr/local/redis/etc/redis.conf
参考页面http://www.jb51.net/article/79096.htm
netstat -tunpl|grep 6379
ps -ef|grep redis
开启redis远程访问
注释bind 127.0.0.1
设置protected-mode no
参考网页https://www.cnblogs.com/liusxg/p/5712493.html


安装本地jar包至本地仓库中：
mvn install:install-file -Dfile=D:\***.jar -DgroupId=*** -DartifactId=*** -Dversion=*** -Dpackaging=jar



@PathVariable和@RequestParam的区别:
	@RequestParam用来获得静态的URL请求参数
	@PathVariable用来获得动态的URL请求入参



swagger的使用
@ApiModelProperty(value="",required=true) 注解使用


mybatis中使用PageInterceptor插件进行分页
<plugins>
	<plugin interceptor="com.github.pagehelper.PageInterceptor">
		<property name="offsetAsPageNum" value="false" />
		<property name="rowBoundsWithCount" value="true" />
		<property name="pageSizeZero" value="true" />
		<property name="reasonable" value="false" />
		<property name="supportMethodsArguments" value="false" />
		<property name="returnPageInfo" value="none" />
	</plugin>
</plugins>

创建rowBounds对象
PageRowBounds pb = new PageRowBounds((pageNumber-1)*pageSize,pageSize);

mybatis中打印sql语句
<setting name="logImpl" value="STDOUT_LOGGING" />


logback.xml配置文件:
https://gitee.com/wjtree/codes/v60iwz1rktdgc95oxu8s418#logback.xml



centos7.2ISO镜像下载
http://vault.centos.org/7.2.1511/isos/x86_64/

linux环境下使用rpm安装mysql并设置mysql用户组以及mysql用户
参考网址:
https://blog.csdn.net/qq_33663251/article/details/54693201
https://blog.csdn.net/qq_33663251/article/details/53671017
http://blog.sina.com.cn/s/blog_4f925fc30102wi6b.html
https://jingyan.baidu.com/article/363872ec3263236e4ba16f07.html
1，检查是否存在mysql相关的安装文件
	rpm -qa | grep mysql
   若存在则移除
	yum -y remove mysql-*
2，检查是否存在mariadb相关的安装文件
	rpm -qa | grep mariadb
   若存在则移除
	rpm -e 文件名 --nodeps
3，查看系统中是否存在mysql的用户组以及用户
   若不存在则创建
	添加用户组:groupadd mysql 
	添加用户:useradd -r -g mysql mysql 
	设置密码:passwd mysql
4，新建文件夹mysql,并设置mysql用户权限
	chown -R mysql:mysql mysql
5，获取相关安装文件，上传至mysql文件夹下
mysql-community-common-5.7.22-1.el7.x86_64.rpm
mysql-community-libs-5.7.22-1.el7.x86_64.rpm
mysql-community-client-5.7.22-1.el7.x86_64.rpm
mysql-community-server-5.7.22-1.el7.x86_64.rpm
6，安装mysql文件
rpm -ivh mysql-community-common-5.7.22-1.el7.x86_64.rpm
rpm -ivh mysql-community-libs-5.7.22-1.el7.x86_64.rpm
rpm -ivh mysql-community-client-5.7.22-1.el7.x86_64.rpm
rpm -ivh mysql-community-server-5.7.22-1.el7.x86_64.rpm
7，今日user/bin目录下，执行初始化命令
	mysqld --initialize --user=mysql
8，查看mysql的初始密码:
	cat /var/log/mysqld.log 
9，启动mysql服务
	service mysqld start
10，登录mysql
	mysql -u root -p 输入mysql的初始密码
11，修改初始密码
	alter user 'root'@'localhost' identified by 'Rltx@123456';
12，设置允许远程连接mysql数据库
	grant all privileges on *.* to 'root'@'%' identified by 'Rltx@123456' with grant option;
13，停止root用户启动的mysql服务
	service mysqld stop
14，切换用户为mysql
	su mysql
15，启动服务
	service mysqld start  输入mysql用户的密码
16，查看mysql服务状态
	service mysqld status
17，关闭防火墙
	iptables -F
18，使用工具连接mysql








