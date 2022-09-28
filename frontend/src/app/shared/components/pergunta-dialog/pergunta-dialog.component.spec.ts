import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerguntaDialogComponent } from './pergunta-dialog.component';

describe('PerguntaDialogComponent', () => {
  let component: PerguntaDialogComponent;
  let fixture: ComponentFixture<PerguntaDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PerguntaDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PerguntaDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
