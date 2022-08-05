FROM nginx:latest
RUN echo 'Hello from nginx' > /usr/share/nginx/html/index.html
EXPOSE 80
