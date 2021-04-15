FROM asap397/firefox-python
WORKDIR /app 
COPY requirements.txt /app
ENV DISPLAY=192.168.56.1:0
RUN pip3 install -r requirements.txt --no-cache-dir
COPY . /app 
ENTRYPOINT ["python3"] 
CMD ["app.py"]
