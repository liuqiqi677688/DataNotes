# Linux系统下查找安装包所在目录的六种方法

想知道Linux系统下安装了哪些软件包，以及软件包安装在哪个目录下，可以用以下6种命令

**1. which**

which命令查找出相关命令是否已经在搜索路径中，例子如下：
$which gcc //显示出GNC的C编译器安装在哪个目录
返回结果为：
/usr/bin/gcc
注意：如果which没有找到要找的命令，可以试试whereis,该命令搜索更大的范围的系统目录。有些系统上的which命令不显示用户没有执行权限的文件。例如

```
$which ipppd
/usr/bin/which :no ipppd in (/bin: /usr/bin: /sbin:/usr/sbin)
$whereis ipppd
ipppd: /usr/sbin/ipppd
$ls -l /usr/sbin/ipppd

-rwx------ 1 root root 124924 Feb 3 2000 /usr/sbin/ipppd
```

**2. locate**
locate命令用于查找文件，它比find命令的搜索速度快，它需要一个数据库，这个数据库由每天的例行工作（crontab）程序来建立。当我们建立好这个数据库后，就可以方便地来搜寻所需文件了。
即先运行：updatedb（无论在那个目录中均可，可以放在crontab中 ）后在 /var/lib/slocate/ 下生成 slocate.db 数据库即可快速查找。在命令提示符下直接执行#updatedb 命令即可。

```
$locate signal.h
/usr/include/asm/signal.h
/usr/include/linux/signal.h
/usr/include/signal.h
/usr/include/sys/signal.h
```

**3. rpm**
如果用户知道自己要查找到软件包的名字，可以直接使用下面的命令。这个命令只在支持rpm的linux版本上有效，如redhat，centos，fedora和suse等。
$ rpm -q python //查找检查系统是否安装了python</p> <p>python-1.5.2-27
或者：$rpm -qa| grep python //这是两个命令的结合

```
rpm的其他用法：
rpm -qa (列出所有安装了的包)
rpm -e package (删除某个包)
rpm -qi package (查询某个包)
rpm -qf command (根据程序查询包的名字)
rpm -ql package (查询某个包所有的安装文件)
```

**4.yum**
yum的参数很多，以下是用于查找软件包的命令。但是也只支持特定的发型版本，centos下最常用的命令

```
$yum list //列出所指定的软件包,后可以加上你想查找的软件包的名字
$yum list installed //列出所有已安装的软件包
$yum info installed //列出所有已安裝的软件包信息
```

**5.whereis**
whereis是查找文件或者命令的所在目录
\#whereis pwd //查找pwd命令所在的目录

**6. find**
		这个命令可用来查找系统是否安装了指定的软件包，更重要的是也可以查找自己对软件包名称记忆不是很清晰的软件包。而且我想是这是所有linux和unix都支持的。

​		find的查找范围很广，功能强大，再搭配用正则表达，效果很好，不过建议尽量缩小搜索范围，减少系统压力，毕竟，当系统文件多了，搜索耗费时间和资源的。

```
$find / -name "python" //从根目录开始查找包含”python“这个字符的文件和文件夹。

find的详细使用有如下例子：
# find . -maxdepth 1 -name *.jpg -print -exec convert 在当前目录下查找，查找深度为一，查找以.jpg结尾文件，并将其转化

# find / -name *.rpm -exec chmod 755 '{}' \; 搜索以 '.rpm' 结尾的文件并定义其权限

# find / -name file1 从 '/' 开始进入根文件系统搜索文件和目录

# find / -perm -u+s 罗列一个系统中所有使用了SUID控制的文件

# find / -user user1 搜索属于用户 'user1' 的文件和目录

# find / -xdev -name \*.rpm 搜索以 '.rpm' 结尾的文件，忽略光驱、捷盘等可移动设备

# find /home/user1 -name '*.txt' | xargs cp -av --target-directory=/home/backup/ --parents 从一个目录查找并复制所有以 '.txt' 结尾的文件到另一个目录

# find /home/user1 -name \*.bin 在目录 '/ home/user1' 中搜索带有'.bin' 结尾的文件

# find /usr/bin -type f -atime +100 搜索在过去100天内未被使用过的执行文件

# find /usr/bin -type f -mtime -10 搜索在10天内被创建或者修改过的文件

# find /var/log -name '*.log' | tar cv --files-from=- | bzip2 > log.tar.bz2 查找所有以 '.log' 结尾的文件并做成一个bzip包
```

