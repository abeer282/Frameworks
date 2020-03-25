import { TokenService } from './../token.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent implements OnInit {

  constructor(private tokenService: TokenService) {
    console.log(tokenService.getToken());
   }

  ngOnInit(): void {
  }

}
