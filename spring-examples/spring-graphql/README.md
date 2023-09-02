spring.graphql.graphiql.enabled=true  
http://localhost:8080/graphiql   

```
query{
  getVehicles(type:"SW"){
    id
    brandName
    launchDate
    type
  }
}
```

```
query{
  getById(id:"1"){
    id
    launchDate  
    brandName
    type
  }
}
```

```
mutation {
  createVehicle(vehicleDto: { 
    type: "SW", 
    modelCode: "2019", 
    brandName: "Audi" }) {
     	id,
    	launchDate,
      brandName
  }
}
```