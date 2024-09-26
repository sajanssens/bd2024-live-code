### Build and run with docker
Prerequisites:
- Install docker, e.g. docker desktop, podman or rancher desktop.

To build this app: 
```
mvn clean package
``` 

To create a docker image:
```
docker build -t hrm .
```

To run this docker image as a container:
```
docker run -it hrm
```

### Sharing

To push this to docker hub:
- create an account on docker hub, e.g. `bramjanssens`
- create a repository on docker hub, e.g. `bd-traineeship` 
- tag your local image to point to docker hub:
  ```
  docker tag hrm bramjanssens/bd-traineeship:v1
  ```
- login to docker hub, e.g.:
  ```
  docker login -u "bramjanssens"
  ```
- push your local image to docker hub:
  ```
  docker push bramjanssens/bd-traineeship:v1
  ```

To pull this image from docker hub:
```
docker pull bramjanssens/bd-traineeship 
```

