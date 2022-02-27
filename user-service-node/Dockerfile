FROM node:16
WORKDIR /app
COPY package*.json ./
ENV NODE_ENV=production
RUN npm install
RUN npm install -g pm2
COPY . /app
EXPOSE 4000
CMD [ "pm2-runtime", "start", "index.js", "--name", "user-service" ]