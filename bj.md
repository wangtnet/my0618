>(git status ,git add ... , git commit -m " " ,git push)
##0620 ��̬�ϴ���
####���� pom�ļ�����
    <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>1.2</version>
        </dependency>
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.4</version>
        </dependency>
###spring mvc���ü���

    <bean id="multipartResolver"  
        class="org.springframework.web.multipart.commons.CommonsMultipartResolver">  
        <!-- Ĭ�ϱ��� -->
        <property name="defaultEncoding" value="utf-8" />  
        <!-- �ļ���С���ֵ -->
        <property name="maxUploadSize" value="10485760000" />  
        <!-- �ڴ��е����ֵ -->
        <property name="maxInMemorySize" value="40960" />  
    </bean>		
