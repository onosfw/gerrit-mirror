# gerrit-mirror
This is a mirror of the ONOSFW repo at https://gerrit.opnfv.org/gerrit/onosfw, which requires a Linux Foundation user account. This repo requires no such login for public access, and is also searchable by the various search engines.

Currently, this is best used on CentOS 7, but we'll be updating shortly for Ubuntu support. 

Pretty much everything important is in framework. There you'll find our source code in src. The build.sh script in the root directory will completely setup all build tools, etc. It can be used to update the ONOS code and apply existing or new patches. This should be used for that purpose. 

We are also working to add support to more seamlessly test the OpenStack ML2 plugin. Our Functest will test the stack, but still requires manual setup. Again, we hope to make this more automated so everything can be built and tested in the build environment. 

If you have any questions, please go to http://forum.onosfw.com. 
