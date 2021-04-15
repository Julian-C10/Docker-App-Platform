from flask import Flask
from flask import request
import subprocess
app = Flask(__name__)

@app.route('/')
def hello():
	subprocess.run(['orange-canvas'])
	return "yay"

if __name__ == '__main__':
	app.run(host='0.0.0.0', port=5005)
