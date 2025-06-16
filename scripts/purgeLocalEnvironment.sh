echo "Removing local environment database + volumes"
docker stop aurora_db
docker rm aurora_db
docker volume rm aurora-db_postgres