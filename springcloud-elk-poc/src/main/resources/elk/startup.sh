docker stack rm elk_poc && \
docker stack deploy -c ./docker-compose.yml elk_poc