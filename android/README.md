1. 安装gradle

   - 由于网络问题可手动下载gradle-8.5-all.zip
   - 下载完成后，找到GRADLE_USER_HOME所在目录。
   - 找到对应的gradle-8.5-all目录，此目录内部已经生成一个唯一编码的目录，把手动下载的zip复制粘贴进去，进行解压。
    
2. 添加local.properties
   
   - 新建local.properties文件
   - 根据Android SDK和flutter的安装目录自定义配置，下面是示例配置
   ```
     sdk.dir=F:\\Android\\Sdk 
     flutter.sdk=F:\\sdks\\flutter
   ```