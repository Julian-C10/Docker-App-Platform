FROM asap397/spyder
# ENV DEBIAN_FRONTEND=noninteractive 
# RUN apt-get update
# RUN apt-get install -y spyder3
# RUN apt-get install -y python 3.8
# RUN apt-get clean
WORKDIR /app 
COPY requirements.txt /app
RUN pip3 install -r requirements.txt --no-cache-dir
COPY . /app 
ENTRYPOINT ["python3"] 
CMD ["app.py"]
