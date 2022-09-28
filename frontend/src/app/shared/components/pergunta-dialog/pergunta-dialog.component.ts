import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';
import { Perguntas } from 'src/app/model/perguntas';
import { PerguntasService } from 'src/app/perguntas/services/perguntas.service';
import { ErrorDialogComponent } from '../error-dialog/error-dialog.component';

@Component({
  selector: 'app-pergunta-dialog',
  templateUrl: './pergunta-dialog.component.html',
  styleUrls: ['./pergunta-dialog.component.scss'],
})
export class PerguntaDialogComponent implements OnInit {
  @Input() id: any;
  

  pergunta: any;

  constructor(
    private perguntasService: PerguntasService,
    public dialog: MatDialog
  ) {
    this.perguntasService.list().subscribe(
      (response: any) => {
        this.pergunta = response[this.id - 1];
        console.log(this.pergunta);
      },
      catchError((error) => {
        this.onError('Erro ao carregar personagens.');
        return of([]);
      })
    );
  }
  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg,
    });
  }

  ngOnInit(): void {}
}
