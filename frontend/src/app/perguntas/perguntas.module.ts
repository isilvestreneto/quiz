import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { PerguntasRoutingModule } from './perguntas-routing.module';
import { PerguntasComponent } from './perguntas.component';

@NgModule({
  declarations: [PerguntasComponent],
  imports: [
    CommonModule,
    AppMaterialModule,
    SharedModule,
    PerguntasRoutingModule,
  ],
})
export class PerguntasModule {}
