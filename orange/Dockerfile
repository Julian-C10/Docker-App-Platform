FROM asap397/orange
#ENV DEBIAN_FRONTEND=noninteractive
# RUN apt-get install -y python3.8
# RUN pip3 install orange3
# RUN pip3 uninstall PyQt5
#RUN pip3 install PyQt5==5.13 PyQt5-sip orange3
# RUN pip3 install PyQt5==5.13 PyQt5-sip
WORKDIR /app
COPY requirements.txt /app
RUN pip3 install -r requirements.txt --no-cache-dir
COPY . /app
ENTRYPOINT ["python3"]
CMD ["app.py"]