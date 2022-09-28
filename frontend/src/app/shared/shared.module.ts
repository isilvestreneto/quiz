import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppMaterialModule } from './app-material/app-material.module';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import { PerguntaDialogComponent } from './components/pergunta-dialog/pergunta-dialog.component';

@NgModule({
  declarations: [
    ErrorDialogComponent,
    PerguntaDialogComponent
  ],
  imports: [CommonModule, AppMaterialModule],
})
export class SharedModule {}
