app = FastAPI()

@app.get('/') 
def read_root():
    return {'status': 'ok'}"