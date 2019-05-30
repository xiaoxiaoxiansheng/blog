#上传已有项目到github

1. git -init
2. git add .
3. git commit -m "first commit"
3. git remote add origin github地址
4.  git pull --rebase origin master
5. git push -u origin master
6. git status

#git命令
1.  git status 查看提交状态
2.  git checkout -- 文件名    从版本库换问这个文件，丢弃工作区的修改
3.  cat readme.md   查看文件
4.  git reset head readme.md    可以把暂存区的修改撤销掉
5.  git diff Head --readme.md   查看版本库和工作区的文件差异
6.  git log 查看提交日志（git log pretty=oneline）
7.  git reset --hard Head^  回退带上一个版本
8.  git reset --hard commitId   回退到指定版本
9.  ssh-keygen -t rsa -C "15101078046@163.com"  本地添加秘钥（-t rsa：指定生成rsa秘钥）默认采用SSH-2的RSA秘钥
10. git remote add origin github地址  本地库链接远程库（需要在远程库上添加秘钥）
11. git push -u origin master,将master分支推送到远程origin上。第一次推送加上-u，不但会把本地的master分支内容推送到远程新的master上
    还会把本地master分支和远程的master分支关联
12. git clone https://github.com/xiaoxiaoxiansheng/blog.git
13. git checkout -b dev(创建并切换到dev分支等同创建： git branch dev； 切换:git checkout dev)
14. git branch ：查看分支
15. git merge dev分支name :   合并dev分支到master上
16. git branch -d dev分支name
17. git status ;cat readme.md;vi readme.md ,重新提交
18. git log --graph 查看分支合并图 
 
##ceshi
Git is a distributed version control system.
Git is free software.

## ceshi master 
git checkout master

## linux 命令
vi 文件名  编辑文件


##ceshi fea 解决冲突
测试解决冲突：

:wq

## linux 命令
vi 文件名 辑文件
:wq 保存退出
