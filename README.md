## README

This repo contains several ysoserial gadgets, transformed into the XStream serialization format.

Original repo: [https://github.com/frohoff/ysoserial](https://github.com/frohoff/ysoserial)


Some gadgets are uploaded in form of .xml, which has to be manually edited for the desired effect. Several gadgets need to be generated using the provided Java class.


## Ported gadgets


```
Gadget                  Author                                        Format      Info
------                  ------                                        ------      ------
URLDNS                  @gebl                                         XML
JRMPClient              @mbechler                                     XML
AspectJWeaver           @Jang                                         XML
CommonsBeanutils1       @frohoff                                      Java
CommonsCollections2     @frohoff                                      Java
CommonsCollections4     @frohoff                                      Java
CommonsCollections6     @matthias_kaiser                              XML
CommonsCollections7     @scristalli, @hanyrax, @EdoardoVignati        XML
C3P0                    @mbechler                                     XML
FileUpload1+            @mbechler + @chudypb bypass for 1.3.1/1.3.2   XML         Fully controlled file upload even for commons-fileupload 1.3.1 and 1.3.2
```


## Dependencies


In order to run Java classes, you need:


* xstream-1.4.17.jar (or any other version)
* kxml2-2.3.0.jar
* ysoserial.jar (see repo provided in the beginning of this README)
