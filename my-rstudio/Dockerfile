FROM asap397/firefox-python
WORKDIR /app 
COPY requirements.txt /app
# RUN apt-get update
# RUN apt-get -y install python3.8
# RUN apt-get -y install python3-pip
# RUN apt-get -y install firefox
RUN pip3 install -r requirements.txt --no-cache-dir
#ENV DISPLAY=192.168.56.1:0.0
#RUN firefox
COPY . /app 
ENTRYPOINT ["python3"] 
CMD ["app.py"]
