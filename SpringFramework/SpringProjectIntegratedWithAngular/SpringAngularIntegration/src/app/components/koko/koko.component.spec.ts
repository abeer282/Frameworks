import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KokoComponent } from './koko.component';

describe('KokoComponent', () => {
  let component: KokoComponent;
  let fixture: ComponentFixture<KokoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KokoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KokoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
