FROM nginx

WORKDIR /app
COPY . .

RUN cp /app/nginx.conf /etc/nginx/nginx.conf
RUN cat /etc/nginx/nginx.conf

RUN rm -rf /etc/nginx/conf.d/default.conf