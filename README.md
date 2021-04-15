# cs1660-project-test
This is the repository for my Course Project Option #1 in CS 1660.

Prerequisites:
    - Have Docker installed on your machine

Steps to run:

0. **ONLY FOR WINDOWS** Run `setDisplay.ps1`. This will create a file named `.env` in the current directory to set the DISPLAY environment variable the containers will use.

1. Run `docker-compose up`. This will start all the containers, and open the GUI. Alternatively you can run `docker-compose up -d` to have a cleaner output in the terminal.

2. When done using the application, run `docker-compose down` to terminate all the containers.

Note that Apache Hadoop and Apache Spark are not implemented.

Common errors:

    Can't connect to X11 Window server using "" as the value of the DISPLAY...

This error occurs on Windows if you did not run `setDisplay.ps1` before running `docker-compose up`, and may typically occur on a linux-based machine if it is a virtual machine. In this case, you will have to change the value of the DISPLAY variable in your environment by going to the terminal and typing `export DISPLAY=<your host IP address>:0`, replacing <your host ip address> with the IP address of your physical machine the virtual machine is running on.
