FROM node:alpine

WORKDIR /app/mock

COPY package*.json ./

RUN npm install

COPY . .

CMD ["npm", "run", "mock"]
