import { KikiService } from './../../services/kiki.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-koko',
  templateUrl: './koko.component.html',
  styleUrls: ['./koko.component.css']
})
export class KokoComponent implements OnInit {
  koko;
  constructor(private kikiService:KikiService)
   { }

  ngOnInit(): void {
    this.koko =this.kikiService.getData();
  }

}
