FROM asap397/firefox-python
RUN apt-get update && apt-get install -y docker.io
WORKDIR /app 
COPY requirements.txt /app
RUN pip3 install -r requirements.txt --no-cache-dir
COPY . /app 
ENTRYPOINT ["python3"] 
CMD ["app.py"]
