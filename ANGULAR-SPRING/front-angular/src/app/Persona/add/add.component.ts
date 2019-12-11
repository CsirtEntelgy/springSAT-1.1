import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Persona } from 'src/app/Models/Persona';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  
  persona:Persona[];
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
  }

  Guardar(persona:Persona){   
    this.service.createPersona(persona)
    .subscribe(data=>{
      this.router.navigate(["listar"]);
    })
     alert("AÑADIDO A BASE");
  }

}
