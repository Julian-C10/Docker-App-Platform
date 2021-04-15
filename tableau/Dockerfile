FROM asap397/firefox-python
COPY requirements.txt /app
WORKDIR /app 
RUN pip3 install -r requirements.txt --no-cache-dir
COPY . /app 
ENTRYPOINT ["python3"] 
CMD ["app.py"]
